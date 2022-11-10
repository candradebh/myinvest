import { createWebHistory, createRouter } from "vue-router";
import NotFound from "@/components/errors/NotFound.vue";
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
    name: "carteiras",
    component: Listcarteiras,
  },
  {
    path: "/show/:id",
    name: "ShowCarteria",
    component: ShowCarteira,
    props: true
  },
  {
    path: "/edit/:ticker",
    name: "CarteiraAtivo",
    component: EditCarteira,
    props: true
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;