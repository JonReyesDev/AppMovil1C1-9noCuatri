package com.example.appholamundo2;

public class ItemsDatos {
    private String txtCategoria;
    private String txtDescripcion;
    private int imageId;

    public ItemsDatos(){
        this.txtCategoria = "";
        this.txtDescripcion = "";
        this.imageId = 0;
    }

    public ItemsDatos(String txtCategoria, String txtDescripcion, int imageId) {
        this.txtCategoria = txtCategoria;
        this.txtDescripcion = txtDescripcion;
        this.imageId = imageId;
    }

    public ItemsDatos(ItemsDatos items) {
        this.txtCategoria = items.txtCategoria;
        this.txtDescripcion = items.txtDescripcion;
        imageId = items.imageId;
    }

    public String getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(String txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }



}

