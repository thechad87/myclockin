package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.PasswordCredential;
import com.chadmarthinussen.factory.PasswordCredentialFactory;
import com.chadmarthinussen.services.PasswordCredentialService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class PasswordCredentialServiceImplTest {

    private static PasswordCredentialService passwordCredentialService;
    private static PasswordCredential passwordCredential;

    @BeforeClass
    public static void setUp() {
        passwordCredentialService = PasswordCredentialServiceImpl.getService();
        passwordCredential = PasswordCredentialFactory.buildPasswordCredential(
                "Ddfdf3@", "samsam", "sam@gmail.com");
        passwordCredentialService.create(passwordCredential);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(passwordCredentialService);
    }

    @Test
    public void create() {
        PasswordCredential newPasswordCredential = passwordCredentialService.create(PasswordCredentialFactory
                .buildPasswordCredential("Ddfdf3@", "samsam", "sam@gmail.com"));
        Assert.assertNotNull(newPasswordCredential);
        Assert.assertSame(newPasswordCredential, passwordCredentialService.read(newPasswordCredential.getUserPasswordCredentials()));
    }

    @Test
    public void read() {
        PasswordCredential readTestAddress = passwordCredentialService.create(PasswordCredentialFactory
                .buildPasswordCredential(
                        "Ddfdf3@", "samsam", "sam@gmail.com"));
        Assert.assertSame(readTestAddress, passwordCredentialService.read(readTestAddress.getUserPasswordCredentials()));
    }

    @Test
    public void update() {
        String newPasswordCred = "Ralph";
        PasswordCredential PasswordUpdate = new PasswordCredential.Builder().copy(passwordCredential).userPasswordCredentials(newPasswordCred).build();
        Assert.assertSame(newPasswordCred, PasswordUpdate.getUserPasswordCredentials());
    }

    @Test
    public void delete() {
        PasswordCredential deletePassword = passwordCredentialService.getAll().stream().findFirst().orElse(null);
        int size = passwordCredentialService.getAll().size();
        assert deletePassword != null;
        passwordCredentialService.delete(deletePassword.getUserPasswordCredentials());
        Assert.assertEquals(size - 1, passwordCredentialService.getAll().size());
    }
}