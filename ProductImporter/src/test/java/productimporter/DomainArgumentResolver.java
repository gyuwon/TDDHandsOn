package productimporter;

import java.util.Optional;
import java.util.Random;

import productimporter.suppliers.wayneenterprises.WayneEnterprisesProductArgumentResolver;

public interface DomainArgumentResolver {
    Optional<Object> tryResolve(Class<?> parameterType);

    static Random random = new Random();

    static DomainArgumentResolver instance = new CompositeArgumentResolver(
            new WayneEnterprisesProductArgumentResolver());
}
