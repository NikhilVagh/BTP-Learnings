import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMono(){
        Mono<?> monoStr = Mono.just("monostr")
                .then(Mono.error(new RuntimeException("Exeception")))
                .log();
        monoStr.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<String> fluxStr = Flux.just("A", "B", "C")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exeception")))
                .log();
        fluxStr.subscribe(System.out::println);

    }
}
