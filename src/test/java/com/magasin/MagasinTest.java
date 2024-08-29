package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void testRegularItem() {
        Item[] items = new Item[] { new Item("Regular Item", 10, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void testComte() {
        Item[] items = new Item[] { new Item("Comté", 10, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    void testPassVipBefore10Days(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 15, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    void testPassVip10Days(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 10, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    void testPassVip5Days(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 5, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    void testKryptonite(){
        Item[] items = new Item[] { new Item("Kryptonite", 0, 80) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Kryptonite", items[0].name);
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    /*************************************************************************/

    @Test
    void testRegularItemQuality() {
        Item[] items = new Item[] { new Item("Regular Item", 10, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testComteQuality() {
        Item[] items = new Item[] { new Item("Comté", 10, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testPassVipQuality(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 1, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(0, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testPassVipQualityDay0(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 0, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testRegularItemExpiration(){
        Item[] items = new Item[] { new Item("Regular Item", 0, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Regular Item", items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

//    @Test
//    void testPouvoirsMagiques(){
//        Item[] items = new Item[] { new Item("Pouvoirs Magiques", 10, 20) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pouvoirs Magiques", items[0].name);
//        assertEquals(9, items[0].sellIn);
//        assertEquals(18, items[0].quality);
//    }
//
//    @Test
//    void testPouvoirsMagiquesExpiration(){
//        Item[] items = new Item[] { new Item("Pouvoirs magiques", 0, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pouvoirs magiques", items[0].name);
//        assertEquals(-1, items[0].sellIn);
//        assertEquals(6, items[0].quality);
//    }    Pouvoirs Magiques est à ajouter dans le code, pour l'instant il n'y sont pas

}
