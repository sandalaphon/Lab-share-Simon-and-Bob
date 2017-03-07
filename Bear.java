import java.util.*;

public class Bear{
  
  private String name;
  private ArrayList<Edible> belly;

  public Bear(String name){
    this.name = name;
    
    this.belly = new ArrayList<Edible>();
  }

  public String getName(){
    return this.name;
  }

  public int foodCount(){
    return belly.size() ;
  }


 public void eat(Edible food){
  belly.add(food);
 }

 // public boolean isBellyFull(){
 //   return foodCount() == belly.length;
 // }

 public void sleep(){
   belly.clear();
  
 }

public Edible throwUp(){
  if(foodCount() > 0){
    return belly.remove(foodCount() - 1);
  }
  return null;
}

public int totalNutrition(){
  int count = 0;
  for (Edible food : belly){
    count = count + food.nutritionValue();
  }
  return count;
}
}
