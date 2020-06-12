import { Subject } from 'rxjs';

import { Master } from '../restapi.service';

export class ShoppingListService {
  ingredientsChanged = new Subject<Master[]>();
//   private ingredients: Master[] = [
//     new Master('Apples', 5),
//     new Master('Tomatoes', 10),
//   ];

//   getIngredients() {
//     return this.ingredients.slice();
//   }

//   addIngredient(ingredient: Ingredient) {
//     this.ingredients.push(ingredient);
//     this.ingredientsChanged.next(this.ingredients.slice());
//   }

//   addIngredients(ingredients: Ingredient[]) {
//     // for (let ingredient of ingredients) {
//     //   this.addIngredient(ingredient);
//     // }
//     this.ingredients.push(...ingredients);
//     this.ingredientsChanged.next(this.ingredients.slice());
//   }
}
