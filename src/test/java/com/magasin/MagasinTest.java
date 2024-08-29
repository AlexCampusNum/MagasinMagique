package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;


class MagasinTest {

    Random random = new Random();

    @Test
    void testRegularItem() {
        int sellIn = random.nextInt(20);
        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Regular Item", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality -1, items[0].quality);
    }

    @Test
    void testComte() {
        int sellIn = random.nextInt(20);
        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Comté", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality +1, items[0].quality);
    }

    @Test
    void testPassVipBefore10Days(){
        int sellIn = 10 + random.nextInt(20);
        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Pass VIP Concert", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality +1, items[0].quality);
    }

    @Test
    void testPassVip10Days(){
        int sellIn = 5 + random.nextInt(6);
        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Pass VIP Concert", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality +2, items[0].quality);
    }

    @Test
    void testPassVip5Days(){
        int sellIn = random.nextInt(6);
        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Pass VIP Concert", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality +3, items[0].quality);
    }

    @Test
    void testKryptonite(){
        int sellIn = random.nextInt(30);
        Item[] items = new Item[] { new Item("Kryptonite", sellIn, 80) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Kryptonite", items[0].name);
        assertEquals(sellIn, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    /*************************************************************************/

    @Test
    void testRegularItemQuality() {
        int sellIn = random.nextInt(30);
        Item[] items = new Item[] { new Item("Regular Item", sellIn, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testComteQuality() {
        int sellIn = random.nextInt(30);
        Item[] items = new Item[] { new Item("Comté", sellIn, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
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
        int sellIn = random.nextInt(31) -30;
        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Regular Item", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Regular Item", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality -2, items[0].quality);
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
//
//    @Test
//    void testPouvoirsMagiques(){
//        Item[] items = new Item[] { new Item("Pouvoirs Magiques", 10, 0) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pouvoirs Magiques", items[0].name);
//        assertEquals(9, items[0].sellIn);
//        assertEquals(0, items[0].quality);
//    }

}
