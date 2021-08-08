import com.getir.domain.Customer;
import com.getir.main.ReadingIsGoodMainClass;
import com.getir.service.StatisticsService;
import com.getir.service.impl.StatisticsServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ReadingIsGoodMainClass.class)
@AutoConfigureDataMongo
public class StatisticsTest {
    @Autowired
    private StatisticsServiceImpl statisticsService;


    @Test
    public void getCountOfOrderedBooks() throws Exception {
        Assertions.assertTrue(statisticsService.getTotalAmountOrder()>=0);
    }


    @Test
    public void getCountOfTotalBooks() throws Exception {
        Assertions.assertTrue(statisticsService.getTotalAmountOfBooks()>=0);
    }


}
