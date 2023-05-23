public class Truck {
    int carregamento;

    public void transporte(double media){
        if(media>=160 && media<=200){
            carregamento = 40;
        }
        else if(media>=200 && media<=250){
            carregamento = 35;
        }
        else if(media>=250 && media<=300){
            carregamento = 30;
        }
        else if(media>=300 && media<=360){
            carregamento = 25;
        }
        else if(media>=360 && media<=400){
            carregamento = 20;
        }
        else if(media>=400 && media<=460){
            carregamento = 18;
        }
        else if(media>=460 && media<=500){
            carregamento = 16;
        }
    }

    public int getCarregamento(){
        return carregamento;
    }
}
