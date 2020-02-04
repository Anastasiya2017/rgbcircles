package ru.khasang.rgbcircles;

//интерфейс, чтобы потом было легче заменить на другую view (легко перенести из одного окружения в другое)
//через этот инт. будем работать с gameManager
public interface iCanvasView {
    //метод для рисования
    void drawCircle(MainCircle circle);

}
