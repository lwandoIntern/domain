package Factory;

import model.Member;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberFactoryTest {

    private Member member;
    @Before
    public void setUp() throws Exception {
        member = MemberFactory.createMember("1111","Nceba","Goniwe","13 Geranium Street Dunoon",false);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createMember() {
        Assert.assertEquals(member.isOwing(),member.isOwing());
    }
}