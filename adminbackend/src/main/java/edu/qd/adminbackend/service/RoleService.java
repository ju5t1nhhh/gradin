package edu.qd.adminbackend.service;

import edu.qd.adminbackend.vo.RestResponse;

import java.util.List;

public interface RoleService {

    RestResponse addRole(String role);

    RestResponse delRole(String role);

    RestResponse listRoles();

    RestResponse modRoleToPerm(int role, List<Integer> perms);

}
