import { createWebHistory, createRouter } from "vue-router";
import NotFound from "@/components/errors/NotFound.vue";
import HelloWorld from "@/components/HelloWorld.vue";
import Listcarteiras from "@/views/carteiras/Carteiras.vue";
import ShowCarteira from "@/views/carteiras/Show.vue";
import EditCarteira from "@/views/carteiras/Edit.vue";

const routes = [
  {
    path: "/:catchAll(.*)",
    component: NotFound,
  },
  {
    path: "/",
    name: "hello",
    component: HelloWorld,
  },
  {
    path: "/carteiras",
    name: "Carteiras",
    component: Listcarteiras,
  },
  {
    path: "/carteiras/show/:id",
    name: "ShowCarteria",
    component: ShowCarteira,
    props: true
  },
  {
    path: "/carteiras/edit/:id",
    name: "EditCarteira",
    component: EditCarteira,
    props: true
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;