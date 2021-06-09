package com.grpccrudclient.service.impl;

import com.grpccrudclient.proto.UserListLimit;
import com.grpccrudclient.proto.UserRestProto;
import com.grpccrudclient.proto.UserRestProtoColl;
import com.grpccrudclient.proto.grcpCrudServiceGrpc;
import com.grpccrudclient.service.UserService;
import com.grpccrudclient.ui.Models.request.UserDetailsRequestModel;
import com.grpccrudclient.ui.Models.response.UserRest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserRest> getUsers(int page, int limit) {
        List<UserRest> returnValue = new ArrayList<>();

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",6565)
                .usePlaintext()
                .build();

        grcpCrudServiceGrpc.grcpCrudServiceBlockingStub stub = grcpCrudServiceGrpc.newBlockingStub(channel);
        UserRestProtoColl userRestProtoColl = stub.readListUser(
                UserListLimit.newBuilder()
                .setPage(page)
                .setLimit(limit)
                .build()
        );

        List<UserRestProto> userRestProtoColls  = userRestProtoColl.getUserRestProtosList();

        for(UserRestProto userRestP : userRestProtoColls){
            UserRest userRest = new UserRest();
            BeanUtils.copyProperties(userRestP, userRest);
            returnValue.add(userRest);
        }

        return returnValue;
    }

    @Override
    public UserRest guardarUsuario(UserDetailsRequestModel userDetails) {
        return null;
    }

    @Override
    public UserRest actualizarUsuario(UserRest userRest) {
        return null;
    }

    @Override
    public UserRest getUserByUserId(String userId) {
        return null;
    }

    @Override
    public String eliminarUsuario(String userId) {
        return null;
    }
}
