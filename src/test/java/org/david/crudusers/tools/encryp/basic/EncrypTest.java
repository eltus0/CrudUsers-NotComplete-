package org.david.crudusers.tools.encryp.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncrypTest {

    @Test
    public void encryp(){
        System.out.println(Encryp.getEncryp().encryp("david"));
    }

    @Test
    public void descryp(){
        System.out.println(Encryp.getEncryp().descryp("li~ql"));
    }

}