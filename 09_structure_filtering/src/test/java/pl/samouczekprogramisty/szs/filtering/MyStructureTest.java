package pl.samouczekprogramisty.szs.filtering;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MyStructureTest {

    private static final Node NODE1 = new Node("code1", "renderer1");
    private static final Node NODE2 = new Node("code2", "renderer2");
    private static final Node NODE3 = new Node("code3", "renderer3");

    private MyStructure emptyStructure;
    private MyStructure filledStructure;

    @BeforeEach
    void setUp() {
        emptyStructure = new MyStructure();

        filledStructure = new MyStructure();
        filledStructure.addNode(NODE1);
        filledStructure.addNode(NODE2);
        filledStructure.addNode(NODE3);
    }

    @Test
    void shouldBeAbleToInstantiateClass() {
        assertThat(emptyStructure, notNullValue());
    }

    @Test
    void shouldReturnNullWhenNotFoundByCodeAndStructureIsEmpty() {
        assertThat(emptyStructure.findByCode("xxx"), is(nullValue()));
    }

    @Test
    void shouldReturnNullWhenNotFoundByRendererAndStructureIsEmpty() {
        assertThat(emptyStructure.findByRenderer("xxx"), is(nullValue()));
    }

    @Test
    void shouldReturn0WhenStructureIsEmpty() {
        assertThat(emptyStructure.count(), is(equalTo(0)));
    }

    @Test
    void shouldBeAbleToAddNodesToStructure() {
        emptyStructure.addNode(new Node("code1", "renderer1"));
        assertThat(emptyStructure.count(), is(1));
    }

    @Test
    void shouldReturnNullWhenNotFoundByCode() {
        emptyStructure.addNode(new Node("code1", "renderer1"));
        assertThat(emptyStructure.findByCode("code2"), is(nullValue()));
    }

    @Test
    void shouldReturnNullWhenNotFoundByRenderer() {
        emptyStructure.addNode(new Node("code1", "renderer1"));
        assertThat(emptyStructure.findByRenderer("renderer2"), is(nullValue()));
    }

    @Test
    void shouldReturnNodeFoundByCode() {
        assertThat(filledStructure.findByCode("code2"), is(sameInstance(NODE2)));
    }

}