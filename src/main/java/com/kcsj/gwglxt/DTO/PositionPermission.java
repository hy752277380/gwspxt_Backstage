package com.kcsj.gwglxt.DTO;

import com.kcsj.gwglxt.entity.Permission;
import com.kcsj.gwglxt.entity.Position;

public class PositionPermission {
    private Position position;
    private Permission permission;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
