package com.magasin;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.api.DisplayName;



class MagasinTest {

    static Random random = new Random();

    static Stream<Arguments> generateRegularItemParams() {
        return Stream.generate(() -> Arguments.of(
                1 + random.nextInt(20),
                random.nextInt(50)
        )).limit(1000);
    }

    @ParameterizedTest
    @MethodSource("generateRegularItemParams")
    @DisplayName("Test Regular Item with Random Parameters")
    void testRegularItem(int sellIn, int quality) {
        Item[] items = new Item[] { new Item("Regular Item", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(Math.max(quality - 1, 0), items[0].quality);
    }

    static Stream<Arguments> generateComteParams() {
        return Stream.generate(() -> Arguments.of(
                1 + random.nextInt(20),
                random.nextInt(50)
        )).limit(1000);
    }

    @ParameterizedTest
    @MethodSource("generateComteParams")
    @DisplayName("Test Comté with Random Parameters")
    void testComte(int sellIn, int quality) {
        Item[] items = new Item[] { new Item("Comté", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality + 1, items[0].quality);
    }

    static Stream<Arguments> generateVipBefore10DaysParams() {
        return Stream.generate(() -> Arguments.of(
                11 + random.nextInt(20),
                random.nextInt(51)
        )).limit(1000);
    }

    @ParameterizedTest
    @MethodSource("generateVipBefore10DaysParams")
    @DisplayName("Test Pass VIP Concert with Random Parameters")
    void testVipBefore10Days(int sellIn, int quality) {
        Item[] items = new Item[] { new Item("Pass VIP Concert", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(Math.min(quality + 1, 50), items[0].quality);
    }


    static Stream<Arguments> generatePassVip10DaysParams() {
        return Stream.generate(() -> Arguments.of(
                6 + random.nextInt(5),
                random.nextInt(49)
        )).limit(200);
    }

    @ParameterizedTest
    @MethodSource("generatePassVip10DaysParams")
    @DisplayName("Test Pass VIP Concert with Random Parameters")
    void testPassVip10Days(int sellIn, int quality) {
        Item[] items = new Item[] { new Item("Pass VIP Concert", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(Math.min(quality + 2, 50), items[0].quality);
    }


    static Stream<Arguments> generatePassVip5DaysParams() {
        return Stream.generate(() -> Arguments.of(
                1 + random.nextInt(5),
                random.nextInt(49)
        )).limit(200);
    }

    @ParameterizedTest
    @MethodSource("generatePassVip5DaysParams")
    @DisplayName("Test Pass VIP Concert with Random Parameters")
    void testPassVip5Days(int sellIn, int quality) {
        Item[] items = new Item[] { new Item("Pass VIP Concert", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(Math.min(quality + 3, 50), items[0].quality);
    }

    static Stream<Arguments> generateKryptoniteParams() {
        return Stream.generate(() -> Arguments.of(
                random.nextInt(100)
        )).limit(100);
    }

    @ParameterizedTest
    @MethodSource("generateKryptoniteParams")
    @DisplayName("Test Kryptonite with Random Parameters")
    void testKryptonite(int sellIn) {
        Item[] items = new Item[] { new Item("Kryptonite", sellIn, 80) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    /*************************************************************************/

    static Stream<Arguments> generateRegularItemQualityParams() {
        return Stream.generate(() -> Arguments.of(
                1 + random.nextInt(30)
        )).limit(30);
    }

    @ParameterizedTest
    @MethodSource("generateRegularItemQualityParams")
    @DisplayName("Test Regular Item with Random Parameters")
    void testRegularItemQuality(int sellIn) {
        Item[] items = new Item[] { new Item("Regular Item", sellIn, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    static Stream<Arguments> generateComteQualityParams() {
        return Stream.generate(() -> Arguments.of(
                random.nextInt(30)
        )).limit(30);
    }

    @ParameterizedTest
    @MethodSource("generateComteQualityParams")
    @DisplayName("Test Comté with Random Parameters")
    void testComteQuality(int sellIn) {
        Item[] items = new Item[] { new Item("Comté", sellIn, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn -1, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    static Stream<Arguments> generatePassVipQualityParams() {
        return Stream.generate(() -> Arguments.of(
                1 + random.nextInt(30)
        )).limit(30);
    }

    @ParameterizedTest
    @MethodSource("generatePassVipQualityParams")
    @DisplayName("Test Pass VIP Concert with Random Parameters")
    void testPassVipQuality(int sellIn) {
        Item[] items = new Item[] { new Item("Pass VIP Concert", sellIn, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn -1, items[0].sellIn);
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


    static Stream<Arguments> generateRegularItemExpirationParams() {
        return Stream.generate(() -> Arguments.of(
                random.nextInt(31) -30,
                2 + random.nextInt(51)
        )).limit(1500);
    }

    @ParameterizedTest
    @MethodSource("generateRegularItemExpirationParams")
    @DisplayName("Test Regular Item with Random Parameters")
    void testRegularItemExpiration(int sellIn, int quality) {
        Item[] items = new Item[] { new Item("Regular Item", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(Math.max(quality - 2, 0), items[0].quality);
    }

//    @Test
//    void testRegularItemExpiration(){
//        int sellIn = random.nextInt(31) -30;
//        int quality = 2 + random.nextInt(51);
//        Item[] items = new Item[] { new Item("Regular Item", sellIn, quality) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Regular Item", items[0].name);
//        assertEquals(sellIn -1, items[0].sellIn);
//        assertEquals(quality -2, items[0].quality);
//    }

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
//    }
//
//    @Test
//    void testPouvoirsMagiquesQuality(){
//        Item[] items = new Item[] { new Item("Pouvoirs Magiques", 10, 0) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pouvoirs Magiques", items[0].name);
//        assertEquals(9, items[0].sellIn);
//        assertEquals(0, items[0].quality);
//    }

}
