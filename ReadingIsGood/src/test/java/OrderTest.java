import com.getir.domain.Book;
import com.getir.domain.Customer;
import com.getir.domain.Order;
import com.getir.main.ReadingIsGoodMainClass;
import com.getir.repository.BookRepository;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import com.getir.service.impl.OrderServiceImpl;
import org.assertj.core.api.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import  org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
//import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= ReadingIsGoodMainClass.class)
@AutoConfigureDataMongo
public class OrderTest {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void saveOrder() throws Exception {
        String id = "testId";
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        Book book = bookRepository.findAll().get(0);
        Customer customer = customerRepository.findAll().get(0);
        Order order = new Order(customer.getId(),book.getId(),now);
        Assertions.assertEquals(order,orderService.save(order));
    }

    @Test
    public void findOrdersById() throws Exception {
        Order order = orderService.findAllOrders().get(0);
        Assertions.assertNotNull(orderService.listOrdersByCustomer(order.getCustomerId()));

    }
}
