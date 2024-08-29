package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;


class MagasinTest {

    Random random = new Random();

    @Test
    void testRegularItem() {
//        int sellIn = 1 + random.nextInt(20);
//        int quality = random.nextInt(50);
        Item[] items = new Item[] { new Item("Regular Item", 10, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }

    @Test
    void testComte() {
        int sellIn = 1 + random.nextInt(20);
        int quality = random.nextInt(50);
        Item[] items = new Item[] { new Item("Comté", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality +1, items[0].quality);
    }

    @Test
    void testPassVipBefore10Days(){
//        int sellIn = 11 + random.nextInt(20);
//        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Pass VIP Concert", 11, 11) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(10, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    void testPassVip10Days(){
//        int sellIn = 6 + random.nextInt(5);
//        int quality = random.nextInt(51);
        Item[] items = new Item[] { new Item("Pass VIP Concert", 10, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    void testPassVip5Days(){
//        int sellIn = random.nextInt(6);
//        int quality = 1 + random.nextInt(51);
        Item[] items = new Item[] { new Item("Pass VIP Concert", 5, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", items[0].name);
        assertEquals(4, items[0].sellIn);
        assertEquals(13, items[0].quality);
    }

    @Test
    void testKryptonite(){
        int sellIn = 1 + random.nextInt(30);
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
        int sellIn = 1 + random.nextInt(30);
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
        int quality = 2 + random.nextInt(51);
        Item[] items = new Item[] { new Item("Regular Item", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Regular Item", items[0].name);
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(quality -2, items[0].quality);
    }

    @Test
    void testPouvoirsMagiques(){
        Item[] items = new Item[] { new Item("Pouvoirs Magiques", 10, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pouvoirs Magiques", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void testPouvoirsMagiquesExpiration(){
        Item[] items = new Item[] { new Item("Pouvoirs magiques", 0, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pouvoirs magiques", items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void testPouvoirsMagiquesQuality(){
        Item[] items = new Item[] { new Item("Pouvoirs Magiques", 10, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pouvoirs Magiques", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

}
