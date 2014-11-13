package factories;

import adapters.ServiceAdapterAlpha;
import adapters.ServiceAdapterBravo;
import org.glassfish.hk2.api.Factory;

import javax.inject.Inject;

public class ServiceAdapterAlphaFactory implements Factory<ServiceAdapterAlpha> {

    @Inject
    private ServiceAdapterBravo serviceAdapterBravo;

    @Override
    public ServiceAdapterAlpha provide() {
        return new ServiceAdapterAlpha(serviceAdapterBravo);
    }

    @Override
    public void dispose(ServiceAdapterAlpha serviceAdapterAlpha) {

    }
}
