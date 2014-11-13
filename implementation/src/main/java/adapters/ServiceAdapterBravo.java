package adapters;

import model.ModelObjectA;
import serviceports.ServicePortBravo;

import javax.inject.Inject;
import java.util.Properties;

public class ServiceAdapterBravo implements ServicePortBravo {

    private final Properties properties;

    @Inject
    public ServiceAdapterBravo(Properties properties) {
        this.properties = properties;
    }

    @Override
    public ModelObjectA doSomething(ModelObjectA modelObjectA) {
        return modelObjectA;
    }
}
