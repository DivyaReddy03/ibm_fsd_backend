import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;



public class BeanFactoryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Greetings g=new Greetings();
		System.out.println(g.getMessage());
		BeanFactory container = new XmlBeanFactory(new FileSystemResource("src/NewFile.xml"));
		Greetings greetings1 = (Greetings) container.getBean("greetings");
		System.out.println(greetings1.getMessage());

	}

}
