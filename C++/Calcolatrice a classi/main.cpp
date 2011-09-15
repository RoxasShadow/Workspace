#include <iostream>
using namespace std;

class Operazioni {
      public:
    double addizione(double a, double b) {
        return (a + b);
    }
    
    double sottrazione(double a, double b) {
        return (a - b);
    }
    
    double moltiplicazione(double a, double b) {
        return (a * b);
    }
    
    double divisione(double a, double b) {
        return (a / b);
    }
} Calc;

int main()
{
    double a, b, res;
    short int op;
     
    cout << "Ciao, benvenuto in CalcDos++ 1.0 di Giovanni Capuano.\n\n";
    cout << "Prego, digita:\n1 se vuoi effettuare un'addizione;\n2 se vuoi effettuare una sottrazione;\n3 se vuoi effettuare una moltiplicazione;\n4 se vuoi effettuare una divisione.";
    cin >> op;
    cout << "\nDigita ora il primo numero dell'operazione: ";
    cin >> a;
    cout << "\nDigita ora il secondo numero dell'operazione: ";
    cin >> b;
    
    switch (op){
        case 1:
            res = Calc.addizione(a, b);
            break;
        case 2:
            res = Calc.sottrazione(a, b);
            break;
        case 3:
            res = Calc.moltiplicazione(a, b);
            break;
        case 4:
            res = Calc.divisione(a, b);
            break;
        default:
            cout << "\nErrore: per selezionare l'operazione da svolgere devi digitare un numero compreso tra 1 e 4. ";
            system("PAUSE");
            return 0;
    }
    cout << "\nRisultato: " << res << "\n";
    system("PAUSE");
    return 0;
}
