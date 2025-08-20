#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using std::string;
using std::unordered_map;
using std::unordered_set;
using std::vector;

class FSMachine {
 public:
  std::vector<std::string> states;
  std::vector<char> alphabet;
  std::unordered_map<std::string, std::string> transFunc;
  std::string currentState;
  std::unordered_set<std::string> accStates;

  FSMachine(std::vector<std::string> states, std::vector<char> alphabet,
            std::unordered_map<std::string, std::string> transFunc,
            std::string currentState,
            std::unordered_set<std::string> accStates) {
    this->states = states;
    this->alphabet = alphabet;
    this->transFunc = transFunc;
    this->currentState = currentState;
    this->accStates = accStates;
  }
};

std::string key(std::string state, char symbol) { return state + symbol; }

bool recognise(std::string input, FSMachine fsMach) {
  for (char symbol : input) {
    fsMach.currentState = fsMach.transFunc[fsMach.currentState + symbol];
  }
  return fsMach.accStates.count(fsMach.currentState);
}

int main() {
  vector<string> states = {"even", "odd"};
  vector<char> alphabet = {'a', 'b'};

  unordered_map<std::string, string> transFunc;

  transFunc[key("even", 'a')] = "odd";
  transFunc[key("even", 'b')] = "even";
  transFunc[key("odd", 'a')] = "even";
  transFunc[key("odd", 'b')] = "odd";

  string start = "even";
  unordered_set<string> acc = {"even"};

  FSMachine m(states, alphabet, transFunc, start, acc);

  std::vector<std::string> tests = {"",    "a",    "aa",    "ab",
                                    "aba", "abba", "bbbabb"};

  std::cout << std::boolalpha;
  for (const auto &s : tests) {
    std::cout << "recognise(\"" << s << "\") = " << recognise(s, m) << '\n';
  }

  return 0;
}
