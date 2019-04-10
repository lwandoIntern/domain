package Factory;

import model.Staff;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffFactoryTest {

    private Staff staff;
    @Before
    public void setUp() throws Exception {
        staff = StaffFactory.createStaff("9999","James","Bond","0417567744","44 Comsmos Street","Admin");
    }

    @Test
    public void createStaff() {
        Assert.assertEquals(staff.getRole(),staff.getRole());
    }
}