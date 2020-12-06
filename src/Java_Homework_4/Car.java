package Java_Homework_4;

public class Car {
    private int yearOfProduction = 2020;
    private String manufacturerName;
    private String model;
    private boolean isTransmissionAutomatic;
    private int numberOfSeats = 5;

    public Car(int yearOfProduction, String manufacturerName, String model, boolean isTransmissionAutomatic, int numberOfSeats) {
        setYearOfProduction(yearOfProduction);
        setManufacturerName(manufacturerName);
        setModel(model);
        setTransmissionAutomatic(isTransmissionAutomatic);
        setNumberOfSeats(numberOfSeats);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.length() < 1) {
            return;
        }
        this.model = model;
    }


    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        if (yearOfProduction < 1886 || yearOfProduction > 2020) {
            return;
        }
        this.yearOfProduction = yearOfProduction;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        if (manufacturerName.length() < 1) {
            return;
        }
        this.manufacturerName = manufacturerName;
    }

    public boolean isTransmissionAutomatic() {
        return isTransmissionAutomatic;
    }

    public void setTransmissionAutomatic(boolean transmissionAutomatic) {
        isTransmissionAutomatic = transmissionAutomatic;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats < 1) {
            return;
        }
        this.numberOfSeats = numberOfSeats;
    }

    public void details() {
        String transmissionType = isTransmissionAutomatic ? "Automatic transmission" :
                "Manual transmission";
        System.out.println(manufacturerName + " " + model + " " + yearOfProduction
                + ", with " + transmissionType + " and " + numberOfSeats + " seats.");
    }
}
