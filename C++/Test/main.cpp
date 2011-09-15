#include <iostream>
using namespace std;

int addizione(int a, int b) {
    return (a + b);
}

int sottrazione(int a, int b) {
    return (a - b);
}

int moltiplicazione(int a, int b) {
    return (a * b);
}

int divisione(int a, int b) {
    return (a / b);
}

int main()
{
    double a, b, op, res;
    cout << "Ciao, benvenuto in CalcDos++ 1.0 di Giovanni Capuano.\n\n";
    cout << "Prego, digita:\n1 se vuoi effettuare un'addizione;\n2 se vuoi effettuare una sottrazione;\n3 se vuoi effettuare una moltiplicazione;\n4 se vuoi effettuare una divisione.";
    cin >> op;
    cout << "\nDigita ora il primo numero dell'operazione: ";
    cin >> a;
    cout << "\nDigita ora il secondo numero dell'operazione: ";
    cin >> b;
    
    if(op == 1) {
          res = addizione(a, b);
          cout << "\nRisultato: " << res;
    }
    else if(op == 2) {
          res = sottrazione(a, b);
          cout << "\nRisultato: " << res;
    }
    else if(op == 3) {
          res = moltiplicazione(a, b);
          cout << "\nRisultato: " << res;
    }
    else if(op == 4) {
          res = divisione(a, b);
          cout << "\nRisultato: " << res;
    }
    else {
          cout << "\nErrore: per selezionare l'operazione da svolgere devi digitare un numero compreso tra 1 e 4.";
    }
}
