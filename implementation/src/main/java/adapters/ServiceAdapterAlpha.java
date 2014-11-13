package adapters;

import model.ModelObjectA;
import serviceports.ServicePortAlpha;
import serviceports.ServicePortBravo;

import javax.inject.Inject;

public class ServiceAdapterAlpha implements ServicePortAlpha {

    private final ServicePortBravo dependencyOnAnotherService;

    @Inject
    public ServiceAdapterAlpha(ServicePortBravo dependencyOnAnotherService) {
        this.dependencyOnAnotherService = dependencyOnAnotherService;
    }

    @Override
    public void doSomething(String someValue) {
        dependencyOnAnotherService.doSomething(new ModelObjectA(someValue));
        System.out.println("Alpha, doing something!!!");
    }
}
