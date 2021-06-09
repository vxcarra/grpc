package com.grpccrudclient.service;

import com.grpccrudclient.ui.Models.request.UserDetailsRequestModel;
import com.grpccrudclient.ui.Models.response.UserRest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserRest> getUsers(int page, int limit);
    UserRest guardarUsuario(UserDetailsRequestModel userDetails);
    UserRest actualizarUsuario(UserRest userRest);
    UserRest getUserByUserId(String userId);
    String eliminarUsuario(String userId);
}
