package app;

import com.caucho.hessian.client.HessianProxyFactory;
import service.MajorService;

import java.net.MalformedURLException;

public class ServiceManager {
    private static ServiceManager serviceManager;
    private MajorService services;

    private ServiceManager(){
        try {
            String url = "http://127.0.0.1:8080/major";
            HessianProxyFactory factory = new HessianProxyFactory();
            factory.setOverloadEnabled(true);
            services = (MajorService) factory.create(MajorService.class, url);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static synchronized ServiceManager getInstance(){
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
        }
        return serviceManager;
    }

    public MajorService getServices(){
        return services;
    }
}
