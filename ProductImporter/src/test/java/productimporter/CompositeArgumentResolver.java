package productimporter;

import java.util.Optional;

public class CompositeArgumentResolver implements DomainArgumentResolver {

    private final DomainArgumentResolver[] resolvers;

    public CompositeArgumentResolver(DomainArgumentResolver... resolvers) {
        this.resolvers = resolvers;
    }

    @Override
    public Optional<Object> tryResolve(Class<?> parameterType) {
        for (DomainArgumentResolver resolver : resolvers) {
            Optional<Object> argument = resolver.tryResolve(parameterType);
            if (argument.isPresent()) {
                return argument;
            }
        }

        return Optional.empty();
    }

}
