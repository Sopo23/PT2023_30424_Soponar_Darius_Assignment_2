package Model;

public class Task{
    private int iD;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    private int arrivalTime;
    private int serviceTime;

    public Task(int iD, int arrivalTime, int serviceTime) {
        this.iD = iD;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    @Override
    public synchronized String toString() {
        return "Client{" +
                "id=" + iD +
                ", arrival=" + arrivalTime +
                ", service=" + serviceTime +
                '}';
    }
}
