import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("Generate")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class BeanInfoAnnotationProcessor extends AbstractProcessor{

	 @Override
	public boolean process(Set<? extends TypeElement> annotations,RoundEnvironment roundEnv) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		for(Element e:roundEnv.getElementsAnnotatedWith(Generate.class)){
        System.out.println(e.asType().getClass().getName());
        
        
     			Map<String,Generate> props = new LinkedHashMap<String, Generate>();
		}
		return false;
	}
	
}
