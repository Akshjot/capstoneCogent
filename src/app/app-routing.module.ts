import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { CategoryViewComponent } from './components/category-view/category-view.component';
import { ContactComponent } from './components/contact/contact.component';
import { EditCartComponent } from './components/edit-cart/edit-cart.component';
import { LoginComponent } from './components/login/login.component';
import { ProductAddComponentComponent } from './components/product-add-component/product-add-component.component';
import { ProductSpecsComponent } from './components/product-specs/product-specs.component';
import { ProductViewComponent } from './components/product-view/product-view.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { UserAccountComponent } from './components/user-account/user-account.component';

const routes: Routes = [
  { path: 'categories/:categoryName', component: ProductViewComponent },
  { path: 'categories', component: CategoryViewComponent },
  { path: 'products/:id', component: ProductSpecsComponent },
  { path: 'products', component: ProductViewComponent },
  { path: 'addProduct', component: ProductAddComponentComponent },
  { path: 'login', component: LoginComponent },
  { path: 'cart', component: EditCartComponent },
  { path: 'cart/:cartId', component: EditCartComponent },
  { path: 'cart/user/:userId', component: EditCartComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'about', component: AboutComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'token', component: ProfileComponent },
  { path: '**', redirectTo: 'categories', pathMatch: 'full' },
  { path: 'useraccount', component: UserAccountComponent },
  { path: 'profile', component: ProfileComponent },
];

@NgModule({
  exports: [RouterModule],
})
export class AppRoutingModule {}
