package com.gildedrose;

/**
 * Änderungsvorschläge
 * - Overall/Main Goal notieren: gut genug muss es sein für den Mob
 * Limit of mob
 * Keine Pause machen
 * Pause machen
 */

/**
 * - "Constant include in List"
 * - Switch statement nach property
 * - Sulfuras ändert sich nicht?
 * -
 */

class GildedRose {
    public static final String BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static final String MONGOOSE = "Elixir of the Mongoose";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.name.equals(SULFURAS)) {
                continue;
            }

            if (!item.name.equals(BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    item.quality--;
                }
            }

            if (item.name.equals(BRIE)) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }

            if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    item.quality++;

                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality++;
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality++;
                    }
                }
            }


            item.sellIn--;

            if (item.name.equals(BRIE)) {
                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
            
            if (!item.name.equals(BRIE)) {
                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                } else {
                    if (item.sellIn < 0) {
                        if (item.quality > 0) {
                            item.quality--;
                        }
                    }
                }
            }

        }
    }
}
