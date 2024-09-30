using System;

namespace PhotoOrderSystem
{
    public class Editor
    {
        private size_enum _size;
        private paper_enum _paper;
        private bool _margins;

        public enum paper_enum
        {
            glossy,
            matte
        }

        public enum size_enum
        {
            Size7p5x10,
            Size10x15,
            Size15x21,
            Size21x30
        }

        public Editor(size_enum size, paper_enum paper, bool margins, Order order)
        {
            _size = size;
            _paper = paper;
            _margins = margins;
        }

        public size_enum Size
        {
            get { return _size; }
            set { _size = value; }
        }

        public paper_enum Paper
        {
            get { return _paper; }
            set { _paper = value; }
        }
        public bool Margins
        {
            get { return _margins; }
            set { _margins = value; }

        }
        public virtual void ChangeSize()
        {
            Console.WriteLine("Select paper size:");
            Console.WriteLine("1. 7.5 x 10 cm");
            Console.WriteLine("2. 10 x 15 cm");
            Console.WriteLine("3. 15 x 21 cm");
            Console.WriteLine("4. 21 x 30 cm");
            Console.Write("Enter number: ");
            int choice;

            if (int.TryParse(Console.ReadLine(), out choice))
            {
                switch (choice)
                {
                    case 1:
                        Size = size_enum.Size7p5x10;
                        Console.WriteLine("Paper size changed to 7.5 x 10 cm.");
                        break;
                    case 2:
                        Size = size_enum.Size10x15;
                        Console.WriteLine("Paper size changed to 10 x 15 cm.");
                        break;
                    case 3:
                        Size = size_enum.Size15x21;
                        Console.WriteLine("Paper size changed to 15 x 21 cm.");
                        break;
                    case 4:
                        Size = size_enum.Size21x30;
                        Console.WriteLine("Paper size changed to 21 x 30 cm.");
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Paper size not changed.");
                        break;
                }
            }
            else
            {
                Console.WriteLine("Invalid input. Paper size not changed.");
            }
        }

        public virtual void ChangePaper()
        {
            Console.WriteLine("Select paper type:");
            Console.WriteLine("1. Glossy");
            Console.WriteLine("2. Matte");
            Console.Write("Enter number: ");
            int choice;

            if (int.TryParse(Console.ReadLine(), out choice))
            {
                switch (choice)
                {
                    case 1:
                        Paper = paper_enum.glossy;
                        Console.WriteLine("Paper type changed to glossy.");
                        break;
                    case 2:
                        Paper = paper_enum.matte;
                        Console.WriteLine("Paper type changed to matte.");
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Paper type not changed.");
                        break;
                }
            }
            else
            {
                Console.WriteLine("Invalid input. Paper type not changed.");
            }
        }

        public virtual void ChooseMargins()
        {
            Console.Write("Set margins? (Yes/No): ");
            string input = Console.ReadLine().ToLower();

            if (input == "yes")
            {
                Margins = true;
                Console.WriteLine("Margins set.");
            }
            else if (input == "no")
            {
                Margins = false;
                Console.WriteLine("Margins not set.");
            }
            else
            {
                Console.WriteLine("Invalid input. Margins not changed.");
            }
        }

        public virtual void ShowFinalOrder()
        {
            Console.WriteLine("Final order:");
            Console.WriteLine($"Size: {_size}");
            Console.WriteLine($"Paper type: {_paper}");
            Console.WriteLine($"Margins: {(_margins ? "Yes" : "No")}");
        }
    }
}