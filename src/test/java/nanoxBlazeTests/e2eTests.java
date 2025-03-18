package nanoxBlazeTests;

import nanoxBlazePageObjects.CartPage;
import nanoxBlazePageObjects.HomePage;
import nanoxBlazePageObjects.PlaceOrderPage;
import nanoxBlazePageObjects.ProductPage;
import nanoxBlazeUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class e2eTests extends BaseTest{

    @Test(description = "Verify that an item can be added to the cart")
    public void tc01() {
        HomePage hp = new HomePage(driver);
        hp.selectItemCard(ConfigReader.get("product.nokia"));
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
        pp.goToCartPage();
        CartPage cp = new CartPage(driver);
        System.out.println("Item added to cart: "+cp.getItem());
        String expectedItem = ConfigReader.get("product.nokia");
        String actualItem = cp.getItem();
        Assert.assertEquals(expectedItem,actualItem,"the added item should be:"+expectedItem);
        cp.deleteItem();
        cp.goToHomePage();

    }

    @Test(description = "Verify that a complete purchase can be made")
    public void tc02_validateCompletePurchase() {
        HomePage hp = new HomePage(driver);
        hp.selectItemCard(ConfigReader.get("product.samsung"));
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();
        pp.goToCartPage();
        CartPage cp = new CartPage(driver);
        System.out.println("Item added to cart: "+cp.getItem());
        String expectedItem = ConfigReader.get("product.samsung");
        String actualItem = cp.getItem();
        Assert.assertEquals(expectedItem,actualItem,"the added item should be:"+expectedItem);
        cp.placeOrder();
        PlaceOrderPage pop = new PlaceOrderPage(driver);
        pop.placeOrder(
                ConfigReader.get("order.name"),
                ConfigReader.get("order.country"),
                ConfigReader.get("order.city"),
                ConfigReader.get("order.card.number"),
                ConfigReader.get("order.card.month"),
                ConfigReader.get("order.card.year")
        );
        pop.confirmPurchase();
        String actualMessage = pop.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains(ConfigReader.get("order.name")), "The message does not contain the expected name");
        Assert.assertTrue(actualMessage.contains(ConfigReader.get("order.card.number")), "The message does not contain the expected card digits.");
        pop.closePlaceOrder();
        cp.goToHomePage();
        String actualURL = hp.getHomePageUrl();
        String expectedURL = ConfigReader.get("app.url");
        Assert.assertEquals(actualURL,expectedURL);
    }

}
