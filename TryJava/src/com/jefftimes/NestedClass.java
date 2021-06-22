package com.jefftimes;

import java.util.ArrayList;



class Invoice {

    private static class Item {
        String description;
        int quantity;
        double unitPrice;
        Item(){ }
        Item(String des, int q, double up){
            description= des;
            quantity = q;
            unitPrice = up;
        }
        double price() {
            return quantity * unitPrice;
        }
    }

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String desc, int quantity, double unitPrice){
        Item item = new Item();
        Item item2 = new Item(desc,quantity,unitPrice);
        item.description = desc;
        item.quantity = quantity;
        item.unitPrice = unitPrice;
        items.add(item);
        items.add(item2);
    }

    public void printInvoiceItems() {

        for(Item item : Invoice.this.items){
            System.out.println(item.description + ":" + item.quantity + ":" + item.unitPrice);
        }

    }

    public static class PublicItem {
        String description;
        int quantity;
        double unitPrice;
        public PublicItem(String des, int q, double up){
            description= des;
            quantity = q;
            unitPrice = up;
        }
        double price() {
            return quantity * unitPrice;
        }
    }
    private ArrayList<PublicItem> pubItems = new ArrayList<PublicItem>();
    public void add(PublicItem item){
        this.pubItems.add(item);
    }

    public void printInvoicePubItems() {
        for(PublicItem item : Invoice.this.pubItems){
            System.out.println(item.description + ":" + item.quantity + ":" + item.unitPrice );
        }

    }

    public boolean isSameInvoice(Invoice invoice){
        return this == invoice;
    }

    public static void main(){

        System.out.println("test from nested class.");
        Invoice invoice = new Invoice();
        invoice.addItem("cup",2,10.0);
        invoice.printInvoiceItems();

        Invoice.PublicItem localPubItem = new PublicItem("fork",5,2.1);
        invoice.add(localPubItem);
        invoice.printInvoicePubItems();

        Invoice invoice2 = new Invoice();
        invoice2.addItem("milk",2,5.0);
        invoice2.printInvoiceItems();

        System.out.println(invoice.isSameInvoice(invoice));
        System.out.println(invoice2.isSameInvoice(invoice));

    }
}