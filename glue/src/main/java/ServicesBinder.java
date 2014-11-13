import adapters.JsonPostService;
import adapters.ServiceAdapterAlpha;
import adapters.ServiceAdapterBravo;
import factories.PropertiesFactory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import serviceports.PostService;
import serviceports.ServicePortAlpha;
import serviceports.ServicePortBravo;

import java.util.Properties;

public class ServicesBinder extends AbstractBinder {

    /*
        TIPS FOR BINDING
        bind: Start building a new instance-based service binding(In other
        words, binds to an instance/specific implementation)
        bindFactory: Start building a new factory class-based service binding.
        bindContract:Start building a new class-based service binding.
        in(Singleton): Used to bind as a singletone instance
        Note: Order matters
        */

    @Override
    protected void configure() {
        bindFactory(PropertiesFactory.class)
                .to(Properties.class);
        //Has a dependency on Properties
        bindAsContract(ServiceAdapterBravo.class)
                .to(ServicePortBravo.class);
        //Has a dependency to ServiceAdapterBravo
        bindAsContract(ServiceAdapterAlpha.class)
                .to(ServicePortAlpha.class);

        bindAsContract(JsonPostService.class)
                .to(PostService.class);


//TODO
//        -Use Jersey client and Jackson to post(See Poseidon how
//        posts to Rockefeller)
    }
}
