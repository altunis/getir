import com.getir.domain.Book;
import com.getir.domain.Customer;
import com.getir.main.ReadingIsGoodMainClass;
import com.getir.service.impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ReadingIsGoodMainClass.class)
@AutoConfigureDataMongo
public class CustomerTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerServiceImpl customerService;


    @Test
    public void saveCustomer() throws Exception {
        Customer customer = new Customer("ismail","altun");
        Assertions.assertEquals(customer,customerService.save(customer));
    }
}
