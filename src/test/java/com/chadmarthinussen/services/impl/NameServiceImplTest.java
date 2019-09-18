package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import com.chadmarthinussen.factory.NameFactory;
import com.chadmarthinussen.services.NameService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NameServiceImplTest {


    private static NameService nameService;
    private static Name name;

    @BeforeClass
    public static void setUp() {
        nameService = NameServiceImpl.getService();
        name = NameFactory.buildName("nam12", "bill", "moneyman", "gates");
        nameService.create(name);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(nameService);
    }

    @Test
    public void create() {
        Name newName = nameService.create(NameFactory.buildName("nam12", "bill", "moneyman", "gates"));
        Assert.assertNotNull(newName);
        Assert.assertSame(newName, nameService.read(newName.getNameID()));
    }

    @Test
    public void read() {
        Name readName = nameService.create(NameFactory.buildName(
                "nam12", "bill", "moneyman", "gates"));
        Assert.assertSame(readName, nameService.read(readName.getNameID()));
    }

    @Test
    public void update() {
        String newNameID = "nam12";
        Name nameTemp = new Name.Builder().copy(name).nameID(newNameID).build();
        Assert.assertSame(newNameID, nameTemp.getNameID());
    }

    @Test
    public void delete() {
        Name deleteName = nameService.getAll().stream().findFirst().orElse(null);
        int size = nameService.getAll().size();
        assert deleteName != null;
        nameService.delete(deleteName.getNameID());
        Assert.assertNull( nameService.getAll().size());
    }
}