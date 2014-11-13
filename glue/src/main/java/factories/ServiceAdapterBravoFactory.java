package factories;

import adapters.ServiceAdapterBravo;
import org.glassfish.hk2.api.Factory;

import javax.inject.Inject;
import java.util.Properties;

public class ServiceAdapterBravoFactory implements Factory<ServiceAdapterBravo> {

//This is a factory to create implementations of the ServiceAdapterBravo
//We need to use factories when the service has dependencies
    @Inject
    private Properties properties;

    @Override
    public ServiceAdapterBravo provide() {
        return new ServiceAdapterBravo(properties);
    }

    @Override
    public void dispose(ServiceAdapterBravo serviceAdapterBravo) {

    }
}
