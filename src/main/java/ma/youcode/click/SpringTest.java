package ma.youcode.click;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.youcode.click.service.*;
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PublisherService service = context.getBean("publisherService",PublisherService.class);
        service.findAll().forEach(publisher ->
                System.out.println(
                        publisher.getId() + " - "
                        + publisher.getNom() + " - "
                        + publisher.getEmail()
                )
        );
        ((ClassPathXmlApplicationContext)context).close();
    }
}
