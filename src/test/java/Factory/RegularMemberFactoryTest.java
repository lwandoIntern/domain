package Factory;

import members.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularMemberFactoryTest {

    private Member regular;
    @Before
    public void setUp() throws Exception {
        regular = RegularMemberFactory.createRegularMember("x",null,"01171495555",null,
                8425,"HMN","KMB","NC");
    }

    @Test
    public void createRegularMember() {
        Assert.assertEquals(regular.getCellphone(),regular.getCellphone());
    }
}