package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Permission;
import edu.qd.adminbackend.vo.RestResponse;

public interface PermissionService {

    RestResponse addPerm(Permission permission);

    RestResponse delPerm(int id);

    RestResponse modifyPerm(Permission permission);

    RestResponse listPerm(Permission permission);

    RestResponse listPermByRole(int role);

    RestResponse myPermissions();

}
