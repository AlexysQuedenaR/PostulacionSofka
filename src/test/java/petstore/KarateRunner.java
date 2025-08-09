package petstore;

import com.intuit.karate.junit5.Karate;

class KarateRunner {

    @Karate.Test
    Karate testPetstore() {
        return Karate.run("petstore_usuario").relativeTo(getClass());

    }
}
