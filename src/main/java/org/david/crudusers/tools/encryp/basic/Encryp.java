package org.david.crudusers.tools.encryp.basic;

import org.david.crudusers.tools.encryp.IEncryp;


public class Encryp implements IEncryp {

    private static IEncryp encryp;

    private Encryp() {
    }

    @Override
    public String encryp(String txt) {
        char[] chars = txt.toCharArray();
        for (int i = 0; i < chars.length; i++){
            chars[i] += 8;
        }
        return String.valueOf(chars);
    }

    @Override
    public String descryp(String txt) {
        char[] chars = txt.toCharArray();
        for (int i = 0; i < chars.length; i++){
            chars[i] -= 8;
        }
        return String.valueOf(chars);
    }

    public static IEncryp getEncryp(){
        if (encryp == null) {
            encryp = new Encryp();
        }
        return encryp;
    }
}
