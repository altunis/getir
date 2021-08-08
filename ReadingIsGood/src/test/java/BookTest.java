import com.getir.domain.Book;
import com.getir.domain.Customer;
import com.getir.domain.Order;
import com.getir.domain.UpdateBookStock;
import com.getir.main.ReadingIsGoodMainClass;
import com.getir.repository.BookRepository;
import com.getir.repository.CustomerRepository;
import com.getir.service.BookService;
import com.getir.service.impl.BookServiceImp;
import com.getir.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
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
public class BookTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookServiceImp bookService;

    @Test
    public void saveBook() throws Exception {
        String id = "testId";
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        Book book = new Book("ismail deneme"+ Math.random(),"ismail altun",100);
        Assertions.assertEquals(book,bookRepository.save(book));
    }

    @Test
    public void updateStock() throws Exception{
        Book book = bookRepository.findAll().get(0);
        int amountOfSum = 10;
        Assertions.assertEquals(book.getStock()+10,bookService.updateBookStock(new UpdateBookStock(10,book.getId())).getStock());
    }
}
