import static org.junit.Assert.*;
import org.junit.*;

public class BearTest{
  Bear bear;
  Salmon salmon;
  Human human;
  Chicken chicken;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
    salmon = new Salmon(); 
    human = new Human();
    chicken = new Chicken();
  }

  @Test
  public void hasName(){
    assertEquals("Baloo", bear.getName());
  }

  @Test
  public void bellyStartsEmpty(){
    assertEquals(0, bear.foodCount());
  }

  @Test
  public void canEatSalmon(){
    bear.eat(salmon);
    assertEquals(1, bear.foodCount());
  }

  // @Test
  // public void bellyIsFull(){
  //   for(int i = 0; i<5; i++){
  //     bear.eat(salmon);
  //   }
  //   assertEquals(bear.isBellyFull(), true);
  // }

  // @Test
  // public void canNotEatSalmonWhenBellyFull(){
  //   for(int i = 0; i<10; i++){
  //     bear.eat(salmon);
  //   }
  //   assertEquals(5, bear.foodCount());
  // }

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(human);
    bear.eat(salmon);
    bear.sleep();
    assertEquals(0, bear.foodCount());
  }

  @Test
  public void canEatHuman(){
    bear.eat(human);
    assertEquals(1, bear.foodCount());
  }

  @Test
  public void canThrowUp(){
    bear.eat(salmon);
    Edible food =bear.throwUp();
    Salmon original = (Salmon) food;
    // assertNotNull(food);
    assertEquals("Swimming!" ,original.swim());
  }

@Test
public void canEatChicken(){
  bear.eat(chicken);
  assertEquals(1, bear.foodCount());
}
@Test
public void canCluck(){
  assertEquals("Cluck!", chicken.cluck());
}
@Test 
public void canThrowUpChicken(){
  bear.eat(chicken);
  Edible vomit = bear.throwUp();
  Chicken chick = (Chicken) vomit;
  assertEquals("Cluck!", chick.cluck());
}
@Test
public void hasNutrition(){
  assertEquals(2, chicken.nutritionValue());
}

@Test
public void sumBellyNutrition(){
  bear.eat(chicken);
  bear.eat(human);
  bear.eat(salmon);
  assertEquals(6, bear.totalNutrition());

}
}
