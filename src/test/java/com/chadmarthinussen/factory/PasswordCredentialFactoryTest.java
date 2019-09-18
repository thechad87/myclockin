package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.AccessTypes.PasswordCredential;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class PasswordCredentialFactoryTest {
    @Test
    public void getPasswordCredential() throws Exception {
        String email = "joe@gmail.com";
        PasswordCredential pwdcredential = PasswordCredentialFactory
                .buildPasswordCredential("JoeD", "joe", email);
        Assert.assertNull(email, pwdcredential.getUserEmailAddress());
    }

}